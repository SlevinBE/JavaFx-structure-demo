package com.slevinbe.eventmanager.application.translations;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTranslationProvider implements ITranslationProvider {

    private final ResourceBundle bundle;

    public ResourceBundleTranslationProvider() {
        Locale locale = Locale.getDefault();
        bundle = ResourceBundle.getBundle("translations.EventManagerTranslations", locale);
    }

    @Override
    public String getString(String key) {
        return bundle.getString(key);
    }
}
