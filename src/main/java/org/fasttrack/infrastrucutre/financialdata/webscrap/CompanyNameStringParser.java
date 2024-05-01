package org.fasttrack.infrastrucutre.financialdata.webscrap;

import org.springframework.stereotype.Component;

@Component
public class CompanyNameStringParser {


    public String parseCompanyName(String name) {

        name = name.toLowerCase();

        name = name.replace("ł", "l")
                .replace("ą", "a")
                .replace("ć", "c")
                .replace("ę", "e")
                .replace("ł", "l")
                .replace("ń", "n")
                .replace("ó", "o")
                .replace("ś", "s")
                .replace("ź", "z")
                .replace("ż", "z")
                .replace(" ", "-")
                .replace("\"", "")
                .replace("\\", "")
        ;
        return name;
    }
}
