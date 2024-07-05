
package ravi.varma.saml;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String index(Model model, @AuthenticationPrincipal Saml2AuthenticatedPrincipal principal) {
		String emailAddress = principal.getFirstAttribute("email");
		model.addAttribute("emailAddress", emailAddress);
		model.addAttribute("userAttributes", principal.getAttributes());
		System.out.println(" user is "+principal.getRelyingPartyRegistrationId());
		principal.getAttributes().forEach((a,b)->{System.out.println(a+": "+b);});
		System.out.println("email "+principal.getAttribute("emailaddress"));
		System.out.println();
		
		return "Welcome";
	}

}
