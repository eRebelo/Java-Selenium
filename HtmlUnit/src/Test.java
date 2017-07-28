import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;

public class Test {

	public static void main(String[] args) {

		WebClient webClient = null;

		try {

			webClient = new WebClient(BrowserVersion.CHROME);
			webClient.getCache().setMaxSize(0);
			webClient.getCookieManager().setCookiesEnabled(true);
			webClient.getOptions().setUseInsecureSSL(true);
			webClient.getOptions().setJavaScriptEnabled(true);
			webClient.getOptions().setThrowExceptionOnScriptError(false);
			webClient.getOptions().setRedirectEnabled(true);

			// Get the first page
			HtmlPage page = webClient.getPage("http://mypage.com.br");

			com.gargoylesoftware.htmlunit.html.HtmlForm form = page.getFormByName("form_name");

			form.getInputByName("login_name").setValueAttribute("my_email@gmail.com");

			HtmlInput passWordInput = (HtmlInput) form.getInputByName("password_name");
			passWordInput.removeAttribute("disabled");
			passWordInput.setValueAttribute("password");

			HtmlInput bSubmit = form.getInputByName("button_name");
			bSubmit.removeAttribute("disabled");
			System.out.println(bSubmit.getId());

			HtmlSubmitInput confirmButton = (HtmlSubmitInput) bSubmit;

			WebWindow window = page.getEnclosingWindow();
			confirmButton.click();

			// The loop will wait until the page changes
			while (window.getEnclosedPage() == page) {
				System.out.println("Waiting...");
				Thread.sleep(500);
			}
			// Updating variable for new page
			page = (HtmlPage) window.getEnclosedPage();
			System.out.println("2nd Page : " + page.asText());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			webClient.close();
		}
	}
}