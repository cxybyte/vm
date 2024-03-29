package com.vm.base.service.dto;

/**
 * Created by ZhangKe on 2018/1/12.
 * 上传图片参数信息
 */
public class UpdateHeadImgInfo {
    private Long fileId;
    private Integer x;
    private Integer y;
    private Integer height;
    private Integer width;
    private Integer rotate;
    private Integer scaleX;
    private Integer scaleY;
    private String versions;
    private Long id;//userId

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersions() {
        return versions;
    }

    public void setVersions(String versions) {
        this.versions = versions;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getRotate() {
        return rotate;
    }

    public void setRotate(Integer rotate) {
        this.rotate = rotate;
    }

    public Integer getScaleX() {
        return scaleX;
    }

    public void setScaleX(Integer scaleX) {
        this.scaleX = scaleX;
    }

    public Integer getScaleY() {
        return scaleY;
    }

    public void setScaleY(Integer scaleY) {
        this.scaleY = scaleY;
    }
}
