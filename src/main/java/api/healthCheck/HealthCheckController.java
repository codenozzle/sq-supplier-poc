package api.healthCheck;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author codenozzle
 *
 */
@Controller
@RequestMapping(value = "/api/healthCheck")
@Api(value = "HealthCheck", tags = { "HealthCheck" })
public class HealthCheckController {

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Check to see if the API is operational.")
	public @ResponseBody ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
