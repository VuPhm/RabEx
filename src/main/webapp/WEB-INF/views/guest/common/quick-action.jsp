<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!-- Quick Action Start -->
<div class="container-fluid pb-3 wow slideInDown">
    <div class="bg-light container-xxl p-5">
        <form action="tra-cuu-buu-pham" method="post">
            <div class="position-relative mx-auto mb-3">
                <input name="code" class="form-control border-0 w-100 fs-4 py-5 ps-4 pe-5" type="text" style="height: 75px"
                       placeholder="Nhập mã bưu phẩm/ Đơn hàng bạn cần tra cứu">
                <button type="submit"
                        class="btn btn-primary fs-3 py-3 w-25 w-25 overflow-hidden text-nowrap position-absolute top-0 end-0 mt-2 me-2">
                    Tra cứu
                </button>
            </div>

        </form>
        <div class="row justify-content-center px-3 gap-3">
            <a href="tao-don" class="col-md btn btn-secondary py-5 fs-4 position-relative">
                <i class="fa fa-truck-fast fs-3 me-3"></i>
                Bắt đầu tạo đơn
            </a>
            <a href="uoc-tinh-chi-phi" class="col-md btn btn-secondary py-5 fs-4">
                <i class="fa fa-credit-card fs-3 me-3"></i>
                Ước tính chi phí
            </a>
        </div>
    </div>
</div>
<!-- Quick Action End -->
