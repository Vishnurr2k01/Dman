package com.example.idm;

import config.Appconfig;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import models.FIleInfo;

import java.io.File;
import java.text.DecimalFormat;

public class DownloadManager {
    @FXML
    private TableView<FIleInfo> tableView;

    @FXML
    private TextField urlTextField;
    public int index=0;
    @FXML
    void downloadButtonClicked(ActionEvent event) {
        String url = urlTextField.getText().trim();
        String Filename=url.substring(url.lastIndexOf("/")+1);
        System.out.println("Njekki");
        String status = "STARTING";
        String action = "OPEN";
        String path = Appconfig.DOWNLOAD_PATH+ File.separator+Filename;

        FIleInfo file = new FIleInfo((index+1)+"", Filename,url,status,action,path,"0");
        this.index=this.index+1;
        DownloadThread thread = new DownloadThread(file,this);
        this.tableView.getItems().add(Integer.parseInt(file.getIndex())-1,file);
        thread.start();
        this.urlTextField.setText("");
//        https://nodejs.org/dist/v16.13.1/node-v16.13.1-x64.msi
    }

    public void UpdateUI(FIleInfo metafile) {
        System.out.println(metafile);
       FIleInfo fIleInfo= this.tableView.getItems().get(Integer.parseInt(metafile.getIndex())-1);
       fIleInfo.setStatus(metafile.getStatus());
        DecimalFormat format = new DecimalFormat("0.0");
        fIleInfo.setPer(format.format(Double.parseDouble(metafile.getPer())));
        this.tableView.refresh();

        System.out.println("================================");
    }
    @FXML
    public  void  initialize(){
        TableColumn<FIleInfo,String> sn= (TableColumn<FIleInfo, String>) this.tableView.getColumns().get(0);
        sn.setCellValueFactory(p->{
            return p.getValue().indexProperty();
        });
        TableColumn<FIleInfo,String> fileName= (TableColumn<FIleInfo, String>) this.tableView.getColumns().get(1);
        fileName.setCellValueFactory(p->{
            return p.getValue().nameProperty();
        });
        TableColumn<FIleInfo,String> url= (TableColumn<FIleInfo, String>) this.tableView.getColumns().get(2);
        url.setCellValueFactory(p->{
            return p.getValue().urlProperty();
        });
        TableColumn<FIleInfo,String> status= (TableColumn<FIleInfo, String>) this.tableView.getColumns().get(3);
        status.setCellValueFactory(p->{
            return p.getValue().statusProperty();
        });
        TableColumn<FIleInfo,String> per= (TableColumn<FIleInfo, String>) this.tableView.getColumns().get(4);
        per.setCellValueFactory(p->{
            SimpleStringProperty simpleStringProperty = new SimpleStringProperty();
            simpleStringProperty.set(p.getValue().getPer()+" %");
            return simpleStringProperty;
        });
        TableColumn<FIleInfo,String> action= (TableColumn<FIleInfo, String>) this.tableView.getColumns().get(5);
        action.setCellValueFactory(p->{
            return p.getValue().actionProperty();
        });

    }
}
