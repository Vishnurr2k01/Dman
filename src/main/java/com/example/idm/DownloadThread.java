package com.example.idm;

import models.FIleInfo;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadThread extends  Thread{
    private FIleInfo file;
    DownloadManager manager;

    public DownloadThread(FIleInfo file, DownloadManager manager){
        this.file=file;
        this.manager=manager;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        this.file.setStatus("DOWNLOADING");
        this.manager.UpdateUI(this.file);
        System.out.println("Ithvare ethi");

        try {
//            Files.copy(new URL(this.file.getUrl()).openStream(), Paths.get(this.file.getPath()));
            URL url = new URL(this.file.getUrl());
            URLConnection urlConnection = url.openConnection();
            int fileSize = urlConnection.getContentLength();

            int countByte = 0;
            double per = 0.0;
            double byteSum=0.0;

            BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream());
            FileOutputStream fos = new FileOutputStream(this.file.getPath());

            byte data[] = new byte[1024];

            while (true) {
               countByte=bufferedInputStream.read(data,0,1024);

                if(countByte==-1){
                    break;
                }
               fos.write(data,0,countByte);
               byteSum=byteSum+countByte;

            if(fileSize>0){
                per = (byteSum/fileSize*100);
                this.file.setPer(Double.toString(per));
                this.manager.UpdateUI(this.file);
            }
            }
            fos.close();
            this.file.setPer(100+"");
            this.file.setStatus("DONE");
        }catch (IOException e) {
    this.file.setStatus("FAILED");
            System.out.println("Download Failed");
            e.printStackTrace();
        }
        this.manager.UpdateUI(this.file);



    }
}
