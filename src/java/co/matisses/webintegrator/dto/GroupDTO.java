package co.matisses.webintegrator.dto;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dbotero
 */
@XmlRootElement
public class GroupDTO {
    private String code;
    private String name;

    public GroupDTO() {
    }

    public GroupDTO(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String toXML() throws JAXBException {
        StringWriter sw = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(GroupDTO.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FRAGMENT, true);
        m.marshal(this, sw);
        return sw.toString();
    }

    public static GroupDTO fromXML(String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(GroupDTO.class);
        Unmarshaller un = context.createUnmarshaller();
        return (GroupDTO) un.unmarshal(new StringReader(xml));
    }

    @Override
    public String toString() {
        return "GroupDTO{" + "code=[" + code + "] name=[" + name + "]}";
    }
}
