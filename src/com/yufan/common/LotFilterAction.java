package com.yufan.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings({"rawtypes"})
public class LotFilterAction<T, pk> extends ActionSupport implements Preparable {

    private static final long serialVersionUID = 1L;

    private static final Log log = LogFactory.getLog(LotFilterAction.class);

    private String msg;
    //ͨ��jsonplug ���ظ�ҳ��
    protected Integer opeType;//��������  1Ϊ��ӣ�2Ϊ�޸ģ�3Ϊɾ��
    protected String incorrectMsg;

    private String jsonStr;
    private HttpSession session;

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext servletContext;
    //	protected Map<String, Object> data;
    protected List<Object[]> listObje = new ArrayList<Object[]>();
    //protected Page<T> page = new Page<T>(10);
    private String ctImgPath;//�����ϴ����ļ����������ļ��ĵ�ַ����ֵ.


    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    public void initData() {
//		if (request == null || response == null || servletContext == null) {
        servletContext = ServletActionContext.getServletContext();
        request = ServletActionContext.getRequest();
        response = ServletActionContext.getResponse();
        response.setHeader("Content-type", "text/html;charset=UTF-8");

//		}

    }
//
//	 public String write_Json_result(String flag,Object msg){
//	    	Map<String, Object> map = new HashMap<String, Object>();
//	    	map.put("flag", flag);
//			map.put("msg", msg);
//			String str = JsonUtils.objectToJson(map);
//			return str;
//	    }


    public PrintWriter getWriter() {
        HttpServletResponse response = ServletActionContext.getResponse();
        PrintWriter writer;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            log.error("IO�쳣");
            e.printStackTrace();
            return null;
        }
        return writer;
    }

    public static String httpPost(String httpUrl, String httpJson) {
        StringBuffer result = new StringBuffer();
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url
                    .openConnection();
            httpURLConnection.setRequestProperty("content-type", "text/xml");
            httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
            httpURLConnection.setRequestProperty("contentType", "UTF-8");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.connect();
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                    httpURLConnection.getOutputStream(), "UTF-8"));
            out.write(httpJson);
            out.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    httpURLConnection.getInputStream(), "UTF-8"));
            while (true) {
                String line = in.readLine();
                if (line == null) {
                    break;
                } else {
                    result.append(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * ���10λ�����
     *
     * @return
     */
    public static String getRandom() {
        int num = (int) Math.round(Math.random() * 25 + 97);
        char temp = (char) num;
        String val = "";
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            val += String.valueOf(random.nextInt(7));
        }
        return temp + val;
    }


    /*
     * ������ֵ
     */
    public static String httpConnSend(String urlStr, String content, String requestMethod) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/xml;charset=UTF-8");//application/json
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod(requestMethod);
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(60000);
            httpURLConnection.connect();
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "utf-8"));
            out.write(content);
            out.flush();
            out.close();
            StringBuffer result = new StringBuffer();
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
            while (true) {
                String line = in.readLine();
                if (line == null) {
                    break;
                } else {
                    result.append(line);
                }
            }
            return result.toString();
        } catch (Exception e) {
            return null;
        }

    }


    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    public HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    public HttpSession getSession() {
        this.session = this.getRequest().getSession();
        return this.session;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getJsonStr() {
        return jsonStr;
    }

    public void setJsonStr(String jsonStr) {
        this.jsonStr = jsonStr;
    }

    public Integer getOpeType() {
        return opeType;
    }

    public void setOpeType(Integer opeType) {
        this.opeType = opeType;
    }

    public String getIncorrectMsg() {
        return incorrectMsg;
    }

    public void setIncorrectMsg(String incorrectMsg) {
        this.incorrectMsg = incorrectMsg;
    }

//	public Map<String, Object> getData() {
//		return data;
//	}
//
//	public void setData(Map<String, Object> data) {
//		this.data = data;
//	}

    public List<Object[]> getListObje() {
        return listObje;
    }

    public void setListObje(List<Object[]> listObje) {
        this.listObje = listObje;
    }

    @Override
    public void prepare() throws Exception {
//		try{
//			String path = PropertyUtil.getParam("IMG_VIEW_PATH");
//			setCtImgPath(path);
//		}catch(Exception e){
//			log.error(e.getStackTrace(), e);
//		}
    }
//	public Page<T> getPage() {
//		return page;
//	}
//
//
//	public void setPage(Page<T> page) {
//		this.page = page;
//	}

    public String getCtImgPath() {
        return ctImgPath;
    }

    public void setCtImgPath(String ctImgPath) {
        this.ctImgPath = ctImgPath;
    }


}
