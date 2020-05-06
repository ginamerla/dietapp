package com.tortu.api.utils;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.Row;
import be.quodlibet.boxable.VerticalAlignment;
import be.quodlibet.boxable.line.LineStyle;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tortu.api.rest.resources.WPIngredientResultResource;
import com.tortu.api.rest.resources.WPRecipeResultResource;
import com.tortu.api.rest.resources.WPWeekDayResultResource;
import org.apache.commons.lang3.math.Fraction;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class SimpleTable {

    private ObjectMapper objectMapper = new CustomFasterJacksonObjectMapperFactory().createCustomObjectMapper();

    public static void main(String[] args) throws IOException {
        SimpleTable simpleTable = new SimpleTable();
        List<WPWeekDayResultResource> wpList = simpleTable.createObjectFromJson();
        simpleTable.createPDF(wpList);
    }


    private List<WPWeekDayResultResource> createObjectFromJson() throws IOException {
        URL stubUrl = Thread.currentThread().getContextClassLoader().getResource("weekplanjsonexample.json");
        return objectMapper.readValue(stubUrl, objectMapper.getTypeFactory().constructCollectionType(List.class, WPWeekDayResultResource.class));
    }

    private void createPDF(List<WPWeekDayResultResource> resource) throws IOException {
        String outputFileName = "SimpleTable.pdf";
//        if (args.length > 0)
//            outputFileName = args[0];
        // Create a new font object selecting one of the PDF base fonts
//        PDFont fontPlain = PDType1Font.HELVETICA;
        PDFont fontBold = PDType1Font.HELVETICA_BOLD;
//        PDFont fontItalic = PDType1Font.HELVETICA_OBLIQUE;
//        PDFont fontMono = PDType1Font.COURIER;
        // Create a document and add a page to it
        PDDocument document = new PDDocument();
        // PDRectangle.LETTER and others are also possiblE
        // PDPage page = new PDPage(PDRectangle.A4);// portrait
        PDPage page = new PDPage(new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth()));// landscape
        PDRectangle rect = page.getMediaBox();
        // rect can be used to get the page width and height
        document.addPage(page);
        // Start a new content stream which will "hold" the to be created content
        PDPageContentStream cos = new PDPageContentStream(document, page);

        //Dummy Table
        float margin = 10;
        // starting y position is whole page height subtracted by top and bottom margin
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
        // we want table across whole page width (subtracted by left and right margin ofcourse)
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

        boolean drawContent = true;
//        float yStart = yStartNewPage;
        float bottomMargin = 70;
        float yStart = page.getMediaBox().getHeight() - (3 * margin);
        // y position is your coordinate of top left corner of the table
        float yPosition = 550;

        BaseTable table = new BaseTable(yPosition, yStartNewPage,
                bottomMargin, tableWidth, margin, document, page, true, drawContent);

        // the parameter is the row height
        Row<PDPage> headerRow = table.createRow(25);
        // the first parameter is the cell width


        //  Titulos
        Cell<PDPage> cell = null;
        for (WPWeekDayResultResource wp : resource) {
            cell = headerRow.createCell(20, wp.getWeekDay());
            cell.setFont(fontBold);
            cell.setFontSize(10);
            cell.setValign(VerticalAlignment.MIDDLE);
            cell.setTopBorderStyle(new LineStyle(Color.BLACK, 5));
            cell.setFillColor(Color.LIGHT_GRAY);
        }
        table.addHeaderRow(headerRow);
        //TODO: Period iterator : 3 BLD o 5 BALPD
        int periodSize = resource.get(0).getRecipeResultList().size();
        for (int periodIterator = 0; periodIterator < periodSize; periodIterator++) {
            //Periodo 1
//            Row<PDPage> periodRow = table.createRow(20);
//            for (int d = 0; d < resource.size(); d++) {
//                List<WPRecipeResultResource> listaRecetas = resource.get(d).getRecipeResultList();
//                String periodo = listaRecetas.get(periodIterator).getPeriod();
//                cell = periodRow.createCell(20, periodo);
//                cell.setFontSize(10);
//                cell.setBorderStyle(new LineStyle(Color.WHITE,1));
//            }

            //Recetas 1
            Row<PDPage> recetaRow = table.createRow(20);
            for (int d = 0; d < resource.size(); d++) {
                List<WPRecipeResultResource> listaRecetas = resource.get(d).getRecipeResultList();
                String r = listaRecetas.get(periodIterator).getRecipeName();
                cell = recetaRow.createCell(20, r);
                cell.setFontSize(10);
                cell.setBottomBorderStyle(new LineStyle(Color.WHITE, 1));
                cell.setFont(fontBold);
            }

            //Ingredientes 1
            Row<PDPage> recipeRow = table.createRow(20);
            for (int d = 0; d < resource.size(); d++) {
                List<WPRecipeResultResource> listaRecetas = resource.get(d).getRecipeResultList();
                StringBuilder str = new StringBuilder();
                for (WPIngredientResultResource ingrediente : listaRecetas.get(periodIterator).getIngredientResultList()) {
//                    str.append(ingrediente.getQuantity().toString());
                    str.append(quantityFormatter(ingrediente.getQuantity()));
                    str.append(" ");
                    str.append(ingrediente.getUnit());
                    str.append(" ");
                    str.append(ingrediente.getItem());
                    str.append(" ");
                    str.append("\n");
                }
                cell = recipeRow.createCell(20, str.toString().replace("\n", "<br>"));
                cell.setFontSize(10);
            }
        }


        table.draw();

        float tableHeight = table.getHeaderAndDataHeight();
        System.out.println("tableHeight = " + tableHeight);

        // close the content stream
        cos.close();

        // Save the results and ensure that the document is properly closed:
        document.save(outputFileName);
        document.close();
    }


    static private String quantityFormatter(Double number) {
        Fraction g = Fraction.getFraction(number);

        if (g.getDenominator() == 1) {
            Integer entero = g.getNumerator() / g.getDenominator();
            return entero.toString();
        }
        return g.toString();
    }
}



