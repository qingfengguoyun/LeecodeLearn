package com.models.mapStruct;

import com.models.vo.UserVo;
import com.myProject_2024_02_08.entity.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-08T12:20:28+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class MapConstructMappperImpl implements MapConstructMappper {

    @Override
    public UserVo toUserVo(User user) {
        if ( user == null ) {
            return null;
        }

        UserVo userVo = new UserVo();

        userVo.setId( user.getId() );
        userVo.setUserName( user.getUserName() );

        return userVo;
    }
}
