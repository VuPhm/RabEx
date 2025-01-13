package com.rabex.express.core.web;

import java.util.Map;

public sealed interface ActionResult permits MvcActionResult, RestActionResult {

}
