package com.rabex.express.core.web;

import com.rabex.express.security.Authentication;
import com.rabex.express.security.DefaultAuthentication;
import com.rabex.express.security.Principal;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.rabex.express.core.web.WebUtils.forward;
import static com.rabex.express.core.web.WebUtils.redirect;

public abstract class AbstractController extends GenericServlet {

    private Set<HandlerMapping> handlerMappings;

    @Override
    public void init() throws ServletException {
        handlerMappings = new HashSet<>();
        System.out.println("init");
        map(new MappingBuilder(handlerMappings));

    }



    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        doService((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse);
    }

    protected void doService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getPathInfo();

        HttpMethod method = HttpMethod.valueOf(request.getMethod().toUpperCase());

        HandlerMapping handlerMapping = handlerMappings.stream().filter(handlerMapping1 -> handlerMapping1.getPathPattern().matches(path, method)).findFirst().orElse(null);

        if (handlerMapping == null) {
            response.sendError(404);
            return;
        }
        Authentication authentication = getAuthentication(request);
        HandlerAction handlerAction = ServletHandlerAction.ServletHandlerActionBuilder.aServletHandlerAction()
                .request(request)
                .response(response)
                .pathVariables(handlerMapping.getPathPattern().extractPathVariables(path))
                .authentication(authentication)
                .build();
        ActionResult actionResult = handlerMapping.getHandler().handle(handlerAction);
        handleResponse(actionResult, request, response);
    }

    private Authentication getAuthentication(HttpServletRequest request) {
        Principal principal = getPrincipal(request);
        return new DefaultAuthentication(principal);
    }

    private Principal getPrincipal(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        return (Principal) session.getAttribute("principal");
    }

    private void handleResponse(ActionResult actionResult, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (actionResult instanceof RestActionResult restActionResult) {

        } else if (actionResult instanceof MvcActionResult mvcActionResult) {
            handleMvcResponse(mvcActionResult, request, response);
        }
    }

    private void handleMvcResponse(MvcActionResult mvcActionResult, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mvcActionResult.getModels().forEach(request::setAttribute);
        String view = mvcActionResult.getView();
        if (view.startsWith("redirect:")) {
            String redirectUrl = view.replaceFirst("redirect:", "");
            redirect(request, response, redirectUrl, redirectUrl.startsWith("http://") || redirectUrl.startsWith("https://"));

        } else {
            forward(request, response, view);
        }
    }


    protected abstract void map(MappingBuilder builder);

    public static int countPathVariables(String pattern) {
        // Regular expression to match placeholders of the form {anything}
        String regex = "\\{[^/]+\\}";
        return (int) pattern.chars()
                .filter(ch -> ch == '{')
                .count();
    }


    public static class MappingBuilder {
        private Set<HandlerMapping> handlerMappings;

        public MappingBuilder(Set<HandlerMapping> handlerMappings) {
            this.handlerMappings = handlerMappings;
        }

        public void map(HttpMethod method, RequestHandler handler, String... pattern) {
            int count = -1;
            for (String s : pattern) {
                if (count == -1) {
                    count = countPathVariables(s);
                } else {
                    if (count != countPathVariables(s))
                        throw new IllegalArgumentException();
                }
                UrlHandlerMapping mapping = new UrlHandlerMapping(handler, s, method);
                if (!handlerMappings.add(mapping)) {
                    throw new IllegalArgumentException("");
                } else {
                    handlerMappings.add(mapping);
                }
            }

        }


    }


}


class DefaultBindingResult<T> implements BindingResult<T> {

    private Map<String, String> errors;
    private T body;

    public DefaultBindingResult(Map<String, String> errors, T body) {
        this.body = body;
        this.errors = errors == null ? new HashMap<String, String>() : errors;
    }

    @Override
    public boolean hasError() {
        return !errors.isEmpty();
    }

    @Override
    public Map<String, String> errors() {
        return errors;
    }

    @Override
    public T body() {
        return body;
    }
}