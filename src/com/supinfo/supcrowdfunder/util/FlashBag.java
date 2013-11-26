package com.supinfo.supcrowdfunder.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: Gaël Demette
 * Date: 25/11/13
 * Time: 00:32
 */
public class FlashBag {
    public Map<String, ArrayList<String>> flashs = new ConcurrentHashMap();
    private HttpSession session;

    public FlashBag(HttpSession session) {
        this.session = session;
        Map<String, ArrayList<String>> flashs = (Map) session.getAttribute("flashbag");
        if (flashs != null && !flashs.isEmpty())
            this.flashs = flashs;
    }
    public Map<String, ArrayList<String>> getFlashs() {
        return this.flashs;
    }
    public void setFlashs(Map<String, ArrayList<String>> flashs) {
        this.flashs = flashs;
    }
    public ArrayList<String> getFlash(String name) {
        if (this.flashs.get(name) == null)
            this.flashs.put(name, new ArrayList<String>());
        return this.flashs.get(name);
    }
    public void addFlash(String name, String label) {
        ArrayList<String> flashs = this.getFlash(name);
        flashs.add(label);
        this.flashs.put(name, flashs);
    }
    public ArrayList<String> getOnceFlash(String name) {
        ArrayList<String> flashs = this.getFlash(name);
        this.flashs.remove(name);
        return flashs;
    }
    public boolean hasFlashs() {
        return !this.flashs.isEmpty();
    }
    public void persist(HttpServletRequest req) {

        this.session.setAttribute("flashbag", this.flashs);
    }
}
