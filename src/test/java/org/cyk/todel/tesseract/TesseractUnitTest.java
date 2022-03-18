package org.cyk.todel.tesseract;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class TesseractUnitTest {

	@Test
	public void test() {
		String lib = System.getProperty("liblept");
		System.out.println("TesseractUnitTest.test() *************************************** : "+lib);
		if(lib != null && !lib.isBlank())
			System.load(lib);
		ITesseract tesseract = new Tesseract();
		try {
			tesseract.setDatapath(new File(System.getProperty("user.dir"),"data").getAbsolutePath());
			tesseract.setLanguage("fra");
			String text = tesseract.doOCR(new File("data/image04.png"));
			System.out.println("TesseractMain.test() : "+text);
			Assertions.assertEquals("1,234,567,890", StringUtils.stripToNull(text));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}