package com.resumeanalyzer.service;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;

public class PdfService {

    public String extractText(byte[] pdfBytes) throws IOException {

        try (PDDocument document = Loader.loadPDF(pdfBytes)) {

            PDFTextStripper pdfTextStripper = new PDFTextStripper();

            return pdfTextStripper.getText(document);
        }
    }
}
