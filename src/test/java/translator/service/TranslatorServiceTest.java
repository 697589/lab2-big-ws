package translator.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import translator.Application;
import translator.domain.TranslatedText;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TranslatorServiceTest {

  @Autowired
  TranslatorService translatorService;

  @Test
  public void translateTest_en_es() {
    TranslatedText translatedText = translatorService.translate("en", "es", "This is a test of translation service");
    assertEquals("Esto es una prueba de servicio de traducción", translatedText.getTranslation());
  }

  @Test
  public void translateTest_es_en() {
    TranslatedText translatedText = translatorService.translate("es", "en", "dia");
    assertEquals("day", translatedText.getTranslation());
  }

  @Test
  public void translateTest_en_fr() {
    TranslatedText translatedText = translatorService.translate("en", "fr", "What a wonderful day");
    assertEquals("Quelle merveilleuse journée", translatedText.getTranslation());
  }

  @Test
  public void translateTest_fr_en() {
    TranslatedText translatedText = translatorService.translate("fr", "en", "Ceci est un test de service de traduction");
    assertEquals("This is a test of translation service", translatedText.getTranslation());
  }

  @Test
  public void translateTest_fr_es() {
    TranslatedText translatedText = translatorService.translate("fr", "es", "je vais prendre un cafe");
    assertEquals("Voy a tomar un cafe", translatedText.getTranslation());
  }

  @Test
  public void translateTest_es_fr() {
    TranslatedText translatedText = translatorService.translate("es", "fr", "voy a hacer cafe");
    assertEquals("Je vais faire du café", translatedText.getTranslation());
  }
}
