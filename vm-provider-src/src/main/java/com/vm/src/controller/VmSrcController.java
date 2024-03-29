package com.vm.src.controller;

import com.vm.base.config.VmBaseConfig;
import com.vm.base.util.ServiceController;
import com.vm.src.service.dto.VmFilesDto;
import com.vm.src.service.inf.VmSrcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ZhangKe on 2018/2/3.
 */
@Controller
@RequestMapping("/src")
@Scope("prototype")
public class VmSrcController extends ServiceController<VmSrcService> {
    @Autowired
    private VmBaseConfig vmBaseConfig;

    /**
     * 获取视频资源
     *
     * @return
     */
    @RequestMapping(value = "/video", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadVideo(@RequestParam("file") MultipartFile file) throws Exception {
        Long fileId = service.uploadVideo(file);
        return response.putData("videoUrl", vmBaseConfig.getSrcVideoUrl() + "/" + fileId).putData("fileId", fileId);
    }

    /**
     * 获取视频资源
     *
     * @return
     */
    @RequestMapping(value = "/video/{fileId}", method = RequestMethod.GET)
    public void getVideoSrc(@PathVariable("fileId") Long fileId) throws Exception {
        service.sendVideoSrc(fileId, getResponse());
    }


    /**
     * 获取图片资源
     *
     * @return
     */

    @RequestMapping(value = "/img/{fileId}/{width}", method = RequestMethod.GET)
    public void getImgSrc(@PathVariable("fileId") Long fileId, @PathVariable("width") Integer width) throws Exception {
        service.sendImgSrc(fileId, width, getResponse());

    }

    /**
     * 获取图片资源
     *
     * @return
     */

    @RequestMapping(value = "/img/{fileId}", method = RequestMethod.GET)
    public void getImgSrc(@PathVariable("fileId") Long fileId) throws Exception {
        service.sendImgSrc(fileId, getResponse());

    }

    /**
     * 上传图片不压缩
     *
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/img", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadImgFile( @RequestParam("file") MultipartFile file) throws Exception {
        Long fileId = service.saveImg(file, null);
        return response.putData("imgUrl", vmBaseConfig.getSrcImgUrl() + "/" + fileId).putData("fileId", fileId);
    }

    /**
     * 上传图片根据宽高比例压缩
     *
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/img/{width}", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadImgFile( @RequestParam("file") MultipartFile file, @PathVariable("width") Integer width) throws Exception {
        Long fileId = service.saveImg(file, width);
        return response.putData("imgUrl", vmBaseConfig.getSrcImgUrl() + "/" + fileId).putData("fileId", fileId);
    }

    /**
     * 剪切已存在的文件图片
     *
     * @param vmFilesDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/img/cut", method = RequestMethod.POST)
    @ResponseBody
    public Object cutUploadedImgFile(VmFilesDto vmFilesDto) throws Exception {
        Long fileId = service.cutUploadedImgFile(vmFilesDto);
        return response.putData("imgUrl", vmBaseConfig.getSrcImgUrl() + "/" + fileId).putData("fileId", fileId);
    }

    /**
     * 上传并且剪切的文件图片
     *
     * @param vmFilesDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/img/uploadAndCut", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadAndCut(VmFilesDto vmFilesDto) throws Exception {
        Long fileId = service.uploadAndCut(vmFilesDto);
        return response.putData("imgUrl", vmBaseConfig.getSrcImgUrl() + "/" + fileId).putData("fileId", fileId);
    }

}
