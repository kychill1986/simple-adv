package com.yang.framework.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author gw
 * Date : 2014-2-19 下午3:49:43
 * HtmlUtils 
 */
public class HtmlUtils {

    public static String delHTMLTag(String htmlStr) {
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
        String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式

        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); //过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); //过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); //过滤html标签
        
        htmlStr = htmlStr.replaceAll("\\&nbsp;", " "); //过滤&nbsp;

        return htmlStr.trim(); //返回文本字符串
    }

    public static  String replaceCRLF(String html) {
        String dest = "";
        Pattern p = Pattern.compile("\\r|\n");
        if (html != null) {
            Matcher m = p.matcher(html);
            dest = m.replaceAll("");
        }
        return dest;
    }
}
