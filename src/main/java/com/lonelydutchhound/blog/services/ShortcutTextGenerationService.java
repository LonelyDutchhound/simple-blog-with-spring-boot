package com.lonelydutchhound.blog.services;

import com.lonelydutchhound.blog.interfaces.TextGenerator;
import org.springframework.stereotype.Service;

@Service
public class ShortcutTextGenerationService implements TextGenerator {

    @Override
    public String generateText(String text) {
        return text.substring(0, Math.min(text.length(), 49));
    }
}
