package com.alpha.springboot.mapper;

import com.alpha.springboot.bean.MyUrl;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//使用注解加入mapper容器 或者在application类上加包扫描mapperscan
@Mapper
public interface UrlMapper {

    /**
     * 储存短网址
     * @param myUrl
     * @return
     */
    @Insert("insert into shorturl values(default,#{longurl},#{srandom},#{creatTime})")
    public int insUrl(MyUrl myUrl);

    /**
     *根据短网址找到真正的地址
     * @param
     * @return
     */
    @Select("select * from shorturl where srandom = #{0}")
    public MyUrl selBySUrl(String srandom);
}
