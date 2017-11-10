package com.supan.vshare.common.utils;

import com.supan.vshare.common.constants.SeedConst;
import com.supan.vshare.model.DomainInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author supan
 * @Date 2017/11/9 16:40
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class StringCovert {

    /**
     * Registrant Name: 陈绍奇  注册人
     * Creation Date: 2017-09-08T04:59:56Z 注册时间
     * Registry Expiry Date: 2027-09-08T04:59:56Z 过期时间
     * Registrant Name: 陈绍奇\r\n
     * Creation Date: 2017-09-08T04:59:56Z\r\n
     * Registry Expiry Date: 2027-09-08T04:59:56Z\r\n
     */

    public static String findUserName(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        String userName = "";
        while (matcher.find()) {
            String group = matcher.group();
            userName = group.substring(group.length() - 3).replace(" ","");
            if (userName.endsWith("\\")) {
                userName = userName.substring(0, 2);
            }
        }
        return userName;
    }


    public static String findDate(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        String registrDate = null;
        while (matcher.find()) {
            String group = matcher.group();
            registrDate = group.substring(group.length() - 19).replace("T"," ");
        }
        return registrDate;
    }

    public static DomainInfo setDomainInfo(DomainInfo domainInfo, String strVal) {
        domainInfo.setRegistrName(findUserName(strVal,SeedConst.REGEX_NAME));
        domainInfo.setRegistrDate(findDate(strVal, SeedConst.REGEX_DATE_REGISTER));
        domainInfo.setExpiryDate(findDate(strVal,SeedConst.REGEX_DATE_EXPIRY));
        return domainInfo;
    }

    public static void main(String[] args) {
        //find("undefined(\"Domain Name: xn--xhq44jb2fpzhjq2axgj.xn--czru2d\\r\\nInternationalized Domain Name: 东北生态大米.商城\\r\\nRegistry Domain ID: D20170908G10001G_21692429-sc\\r\\nRegistrar WHOIS Server: zhuoyue.wang/whois.html\\r\\nRegistrar URL: http://zhuoyue.wang\\r\\nUpdated Date: 2017-09-10T02:45:54Z\\r\\nCreation Date: 2017-09-08T04:59:56Z\\r\\nRegistry Expiry Date: 2027-09-08T04:59:56Z\\r\\nRegistrar: Beijing Zhuoyue Shengming Technologies Company Ltd.\\r\\nRegistrar IANA ID: 1914\\r\\nRegistrar Abuse Contact Email: abuse@zhuoyue.wang\\r\\nRegistrar Abuse Contact Phone: +86.1057034834\\r\\nDomain Status: ok https://icann.org/epp#OK\\r\\nRegistry Registrant ID: C20170908C_20387247-sc\\r\\nRegistrant Name: 陈绍\\r\\nRegistrant Organization: 陈绍奇\\r\\nRegistrant Street: 黑龙江省肇源县新站镇新肇街\\r\\nRegistrant City: 大庆市\\r\\nRegistrant State/Province: 黑龙江省\\r\\nRegistrant Postal Code: 166500\\r\\nRegistrant Country: CN\\r\\nRegistrant Phone: +86.045151963495\\r\\nRegistrant Phone Ext: \\r\\nRegistrant Fax: +86.045151963496\\r\\nRegistrant Fax Ext: \\r\\nRegistrant Email: 191408428@qq.com\\r\\nRegistry Admin ID: C20170908C_20387247-sc\\r\\nAdmin Name: 陈绍奇\\r\\nAdmin Organization: 陈绍奇\\r\\nAdmin Street: 黑龙江省肇源县新站镇新肇街\\r\\nAdmin City: 大庆市\\r\\nAdmin State/Province: 黑龙江省\\r\\nAdmin Postal Code: 166500\\r\\nAdmin Country: CN\\r\\nAdmin Phone: +86.045151963495\\r\\nAdmin Phone Ext: \\r\\nAdmin Fax: +86.045151963496\\r\\nAdmin Fax Ext: \\r\\nAdmin Email: 191408428@qq.com\\r\\nRegistry Tech ID: C20170908C_20387247-sc\\r\\nTech Name: 陈绍奇\\r\\nTech Organization: 陈绍奇\\r\\nTech Street: 黑龙江省肇源县新站镇新肇街\\r\\nTech City: 大庆市\\r\\nTech State/Province: 黑龙江省\\r\\nTech Postal Code: 166500\\r\\nTech Country: CN\\r\\nTech Phone: +86.045151963495\\r\\nTech Phone Ext: \\r\\nTech Fax: +86.045151963496\\r\\nTech Fax Ext: \\r\\nTech Email: 191408428@qq.com\\r\\nName Server: ns.zhuoyue.wang\\r\\nDNSSEC: unsigned\\r\\nURL of the ICANN Whois Inaccuracy Complaint Form: https://www.icann.org/wicf/\\r\\n>>> Last update of WHOIS database: 2017-11-09T08:27:52Z <<<\\r\\n\\r\\nFor more information on Whois status codes, please visit https://icann.org/epp\\r\\n\\r\\nNOTICE: The expiration date displayed in this record is the date the\\r\\nregistrar's sponsorship of the domain name registration in the registry is\\r\\ncurrently set to expire. This date does not necessarily reflect the expiration\\r\\ndate of the domain name registrant's agreement with the sponsoring\\r\\nregistrar.  Users may consult the sponsoring registrar's Whois database to\\r\\nview the registrar's reported date of expiration for this registration.\\r\\n\\r\\nTERMS OF USE: The information in the Whois database is collected through ICANN-accredited registrars. Zodiac Holdings Limited and its affiliates （“We”） make this information available to you “as is” and do not guarantee its accuracy or completeness. By submitting a Whois query, you agree that you will use this data only for lawful purposes and that, under no circumstances will you use this data： （1） to allow, enable, or otherwise support the transmission of mass unsolicited, commercial advertising or solicitations via direct mail, electronic mail, or by telephone; （2） in contravention of any applicable data and privacy protection laws; or （3） to enable high volume, automated, electronic processes that apply to our registry （or our systems）. Compilation, repackaging, dissemination, or other use of the Whois database in its entirety, or of a substantial portion thereof, is not allowed without our prior written permission. \\r\\n\")");
        String strVal = "undefined(\"Domain Name: xn--xhq44jb2fpzhjq2axgj.xn--czru2d\\r\\nInternationalized Domain Name: 东北生态大米.商城\\r\\nRegistry Domain ID: D20170908G10001G_21692429-sc\\r\\nRegistrar WHOIS Server: zhuoyue.wang/whois.html\\r\\nRegistrar URL: http://zhuoyue.wang\\r\\nUpdated Date: 2017-09-10T02:45:54Z\\r\\nCreation Date: 2017-09-08T04:59:56Z\\r\\nRegistry Expiry Date: 2027-09-08T04:59:56Z\\r\\nRegistrar: Beijing Zhuoyue Shengming Technologies Company Ltd.\\r\\nRegistrar IANA ID: 1914\\r\\nRegistrar Abuse Contact Email: abuse@zhuoyue.wang\\r\\nRegistrar Abuse Contact Phone: +86.1057034834\\r\\nDomain Status: ok https://icann.org/epp#OK\\r\\nRegistry Registrant ID: C20170908C_20387247-sc\\r\\nRegistrant Name: 陈绍奇\\r\\nRegistrant Organization: 陈绍奇\\r\\nRegistrant Street: 黑龙江省肇源县新站镇新肇街\\r\\nRegistrant City: 大庆市\\r\\nRegistrant State/Province: 黑龙江省\\r\\nRegistrant Postal Code: 166500\\r\\nRegistrant Country: CN\\r\\nRegistrant Phone: +86.045151963495\\r\\nRegistrant Phone Ext: \\r\\nRegistrant Fax: +86.045151963496\\r\\nRegistrant Fax Ext: \\r\\nRegistrant Email: 191408428@qq.com\\r\\nRegistry Admin ID: C20170908C_20387247-sc\\r\\nAdmin Name: 陈绍奇\\r\\nAdmin Organization: 陈绍奇\\r\\nAdmin Street: 黑龙江省肇源县新站镇新肇街\\r\\nAdmin City: 大庆市\\r\\nAdmin State/Province: 黑龙江省\\r\\nAdmin Postal Code: 166500\\r\\nAdmin Country: CN\\r\\nAdmin Phone: +86.045151963495\\r\\nAdmin Phone Ext: \\r\\nAdmin Fax: +86.045151963496\\r\\nAdmin Fax Ext: \\r\\nAdmin Email: 191408428@qq.com\\r\\nRegistry Tech ID: C20170908C_20387247-sc\\r\\nTech Name: 陈绍奇\\r\\nTech Organization: 陈绍奇\\r\\nTech Street: 黑龙江省肇源县新站镇新肇街\\r\\nTech City: 大庆市\\r\\nTech State/Province: 黑龙江省\\r\\nTech Postal Code: 166500\\r\\nTech Country: CN\\r\\nTech Phone: +86.045151963495\\r\\nTech Phone Ext: \\r\\nTech Fax: +86.045151963496\\r\\nTech Fax Ext: \\r\\nTech Email: 191408428@qq.com\\r\\nName Server: ns.zhuoyue.wang\\r\\nDNSSEC: unsigned\\r\\nURL of the ICANN Whois Inaccuracy Complaint Form: https://www.icann.org/wicf/\\r\\n>>> Last update of WHOIS database: 2017-11-09T08:27:52Z <<<\\r\\n\\r\\nFor more information on Whois status codes, please visit https://icann.org/epp\\r\\n\\r\\nNOTICE: The expiration date displayed in this record is the date the\\r\\nregistrar's sponsorship of the domain name registration in the registry is\\r\\ncurrently set to expire. This date does not necessarily reflect the expiration\\r\\ndate of the domain name registrant's agreement with the sponsoring\\r\\nregistrar.  Users may consult the sponsoring registrar's Whois database to\\r\\nview the registrar's reported date of expiration for this registration.\\r\\n\\r\\nTERMS OF USE: The information in the Whois database is collected through ICANN-accredited registrars. Zodiac Holdings Limited and its affiliates （“We”） make this information available to you “as is” and do not guarantee its accuracy or completeness. By submitting a Whois query, you agree that you will use this data only for lawful purposes and that, under no circumstances will you use this data： （1） to allow, enable, or otherwise support the transmission of mass unsolicited, commercial advertising or solicitations via direct mail, electronic mail, or by telephone; （2） in contravention of any applicable data and privacy protection laws; or （3） to enable high volume, automated, electronic processes that apply to our registry （or our systems）. Compilation, repackaging, dissemination, or other use of the Whois database in its entirety, or of a substantial portion thereof, is not allowed without our prior written permission. \\r\\n\")";
        String regex = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z";
        strVal = "";
        DomainInfo domainInfo = new DomainInfo();
        domainInfo.setRegistrName(findUserName(strVal,SeedConst.REGEX_NAME));
        domainInfo.setRegistrDate(findDate(strVal, SeedConst.REGEX_DATE_REGISTER));
        domainInfo.setExpiryDate(findDate(strVal,SeedConst.REGEX_DATE_EXPIRY));
        System.out.println(domainInfo);
    }

}
