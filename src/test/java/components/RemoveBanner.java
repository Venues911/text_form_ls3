package components;

import com.codeborne.selenide.Selenide;

public class RemoveBanner {
    public void removeBanner() {
        Selenide.executeJavaScript("$('#fixedban').remove()"); // remove banner
        Selenide.executeJavaScript("$('footer').remove()"); // remove banner
    }
}
