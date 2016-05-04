package com.notes.db.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by pkonwar on 5/3/2016.
 */
@Table(name = "IMAGE_STORER")
public class ImageStorer extends Model{

    public ImageStorer() {
    }

    public ImageStorer(String imageId, byte[] imageBlob) {
        this.imageId = imageId;
        this.imageBlob = imageBlob;
    }

    @Column(name = "IMAGE_ID", unique = true)
    public String imageId;


    @Column(name = "image")
    public byte[] imageBlob;


}
