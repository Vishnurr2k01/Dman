package models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FIleInfo {
    private SimpleStringProperty index=new SimpleStringProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty url=new SimpleStringProperty();
    private SimpleStringProperty Status=new SimpleStringProperty();
    private  SimpleStringProperty action=new SimpleStringProperty();
    private SimpleStringProperty path=new SimpleStringProperty();
    private  SimpleStringProperty per = new SimpleStringProperty();


    public void setName(String name) {
        this.name.set(name);
    }

    public void setUrl(String url) {
        this.url.set(url);
    }

    public void setStatus(String status) {
        this.Status.set(status);
    }

    public String getIndex() {
        return index.get();
    }

    public SimpleStringProperty indexProperty() {
        return index;
    }

    public void setIndex(String index) {
        this.index.set(index);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getUrl() {
        return url.get();
    }

    public SimpleStringProperty urlProperty() {
        return url;
    }

    public String getStatus() {
        return Status.get();
    }

    public SimpleStringProperty statusProperty() {
        return Status;
    }

    public String getAction() {
        return action.get();
    }

    public SimpleStringProperty actionProperty() {
        return action;
    }

    public void setAction(String action) {
        this.action.set(action);
    }

    //    private DownloadManager downloadManagerController;
    public FIleInfo(String index, String name, String url, String Status,String action,String path,String per) {
//        assert false;
        this.index.set(index);
        this.name.set(name);
        this.url.set(url);
        this.Status.set(Status);
        this.action.set(action);
        this.path.set(path);
        this.per.set(per);
    }

    public String getPer() {
        return per.get();
    }

    public SimpleStringProperty perProperty() {
        return per;
    }

    public void setPer(String per) {
        this.per.set(per);
    }

    public String getPath() {
        return path.get();
    }

    public SimpleStringProperty pathProperty() {
        return path;
    }

    public void setPath(String path) {
        this.path.set(path);
    }

    @Override
    public String toString() {
        return "FIleInfo{" +
                "index=" + index +
                ", name=" + name +
                ", url=" + url +
                ", Status=" + Status +
                ", action=" + action +
                ", path=" + path +
                '}';
    }
}
