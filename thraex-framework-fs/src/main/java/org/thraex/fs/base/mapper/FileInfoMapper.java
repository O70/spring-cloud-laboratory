package org.thraex.fs.base.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.thraex.fs.base.entity.FileInfo;

import java.util.List;

/**
 * @author 鬼王
 * @date 2019/12/06 10:23
 */
@Mapper
public interface FileInfoMapper {

    String TABLE_NAME = "FS_FILE_INFO";

    @Select("SELECT * FROM " + TABLE_NAME)
    List<FileInfo> getList();

    @Select("SELECT * FROM " + TABLE_NAME + " WHERE id = #{id}")
    FileInfo findById(String id);

    @Insert("INSERT INTO " + TABLE_NAME
            + "(id, name, content_type, suffix, size, path, directory) VALUES (#{id}, #{name}, #{contentType}, #{suffix}, #{size}, #{path}, #{directory})")
    @SelectKey(statement = "SELECT UUID()", keyProperty = "id", before = true, resultType = String.class)
    int insert(FileInfo info);

    @Delete("DELETE FROM " + TABLE_NAME + " WHERE id = #{id}")
    int delete(String id);

    @Delete("DELETE FROM " + TABLE_NAME)
    int clear();

}