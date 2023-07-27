package com.skillfactory.modules.practice.io;

import com.skillfactory.modules.practice.model.FullInfo;
import com.skillfactory.modules.practice.utils.PracticeConfig;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Date;

@Slf4j
public class XmlWriter {

    private XmlWriter() {

    }

    public static void generateXmlReq(FullInfo fullInfo) {

        try {
            log.info("XML marshalling started");

            JAXBContext jaxbContext = JAXBContext.newInstance(FullInfo.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            PracticeConfig.distCreateIfNotExist();
            File requestFile = new File(PracticeConfig.DIST + "xml-info-" + new Date().getTime() + ".xml");

            marshaller.marshal(fullInfo, requestFile);
        } catch (JAXBException jaxbEx) {
            log.error("XML marshalling failed", jaxbEx);
            return;
        }

        log.info("XML marshalling finished successfully");
    }
}
