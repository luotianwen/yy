/**
 * Copyright 1999-2014 dangdang.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.shifeng.common;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.shifeng.dto.mall.MallUserAddressDTO;
import com.shifeng.dto.mall.ware.SkusDTO;
import com.shifeng.dto.mall.ware.WareSkuDTO;
import com.shifeng.entity.BaseEntity;
import com.shifeng.entity.search.WareSkuInfo;
import com.shifeng.entity.user.SysUser;
import com.shifeng.response.ReqResponse;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * This class must be accessible from both the provider and consumer

 */
public class SerializationOptimizerImpl implements SerializationOptimizer {

    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<Class>();
        // beans

        classes.add(ReqResponse.class);
        classes.add(SysUser.class);
        classes.add(BaseEntity.class);
        classes.add(WareSkuDTO.class);
        classes.add(SkusDTO.class);
        classes.add(WareSkuInfo.class);
        classes.add(MallUserAddressDTO.class);
        return classes;
    }
}
