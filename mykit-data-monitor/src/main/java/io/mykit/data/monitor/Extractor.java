/**
 * Copyright 2020-9999 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mykit.data.monitor;

import io.mykit.data.common.event.Event;

import java.util.List;
import java.util.Map;

/**
 * @author binghe
 * @version 1.0.0
 * @description 任务提取器
 */
public interface Extractor {

    /**
     * 启动定时/日志抽取任务
     */
    void start();

    /**
     * 关闭任务
     */
    void close();

    /**
     * 添加监听器（获取增量数据）
     */
    void addListener(Event event);

    /**
     * 清空监听器
     */
    void clearAllListener();

    /**
     * 定时模式: 监听增量事件
     */
    void changedQuartzEvent(int tableGroupIndex, String event, Map<String, Object> before, Map<String, Object> after);

    /**
     * 日志模式: 监听增量事件
     */
    void changedLogEvent(String tableName, String event, List<Object> before, List<Object> after);

    /**
     * 刷新增量点事件
     */
    void flushEvent();

    /**
     * 异常事件
     */
    void errorEvent(Exception e);
}
