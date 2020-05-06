package com.tortu.api.utils.pdf;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.Row;
import be.quodlibet.boxable.VerticalAlignment;
import be.quodlibet.boxable.line.LineStyle;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tortu.api.rest.resources.WPIngredientResultResource;
import com.tortu.api.rest.resources.WPRecipeResultResource;
import com.tortu.api.rest.resources.WPWeekDayResultResource;
import com.tortu.api.utils.CustomFasterJacksonObjectMapperFactory;
import com.tortu.api.utils.GeneralException;
import org.apache.commons.lang3.math.Fraction;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.List;

@Component
public class PdfCreator {

    private String filePath = "Dieta.pdf";
    private final Logger LOG = LoggerFactory.getLogger(PdfCreator.class);
    private ObjectMapper objectMapper = new CustomFasterJacksonObjectMapperFactory().createCustomObjectMapper();

    public InputStream createPDF(List<WPWeekDayResultResource> resource) throws IOException {
        if(CollectionUtils.isEmpty(resource)){
            return null;
        }
        LOG.info("Creando PDF...");
        String outputFileName = "Dieta.pdf";
        PDFont fontBold = PDType1Font.HELVETICA_BOLD;
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth()));// landscape
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
        //float yStart = yStartNewPage;
        float bottomMargin = 70;
        // y position is your coordinate of top left corner of the table
        float yPosition = 550;

        BaseTable table = new BaseTable(yPosition, yStartNewPage,
                bottomMargin, tableWidth, margin, document, page, true, drawContent);

        //  Titulos
        Row<PDPage> headerRow = table.createRow(25);
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

        int periodSize = resource.get(0).getRecipeResultList().size();//periodSize : 3 BLD o 5 BALPD
        for (int periodIterator = 0; periodIterator < periodSize; periodIterator++) {
            //Recetas
            Row<PDPage> recetaRow = table.createRow(20);
            for (int d = 0; d < resource.size(); d++) {
                List<WPRecipeResultResource> listaRecetas = resource.get(d).getRecipeResultList();
                String r = listaRecetas.get(periodIterator).getRecipeName();
                cell = recetaRow.createCell(20, r);
                cell.setFontSize(10);
                cell.setBottomBorderStyle(new LineStyle(Color.WHITE, 1));
                cell.setFont(fontBold);
            }

            //Ingredientes
            Row<PDPage> recipeRow = table.createRow(20);
            for (int d = 0; d < resource.size(); d++) {
                List<WPRecipeResultResource> listaRecetas = resource.get(d).getRecipeResultList();
                StringBuilder str = new StringBuilder();
                for (WPIngredientResultResource ingrediente : listaRecetas.get(periodIterator).getIngredientResultList()) {
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
        // close the content stream
        cos.close();

        // Save the results and ensure that the document is properly closed:
//        document.save(outputFileName);
//        document.close();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        document.save(out);
        document.close();
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());

        File file = new File(filePath);
        if(file.delete()){
         LOG.info("file deleted");
        }

        LOG.info("Guardando pdf...");
//        return filePath;
            return in;
    }



    private String quantityFormatter(Double number) {
        Fraction g = Fraction.getFraction(number);
        if (g.getDenominator() == 1) {
            Integer entero = g.getNumerator() / g.getDenominator();
            return entero.toString();
        }
        return g.toString();
    }

    private List<WPWeekDayResultResource> createObjectFromJson() throws IOException {
        URL stubUrl = Thread.currentThread().getContextClassLoader().getResource("weekplanjsonexample.json");
        return objectMapper.readValue(stubUrl, objectMapper.getTypeFactory().constructCollectionType(List.class, WPWeekDayResultResource.class));
    }
}
