package org.behappy.canal.annotation;

import com.alibaba.otter.canal.protocol.CanalEntry;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * ListenPoint for update
 *
 * @author jigua
 * @date 2018/3/19
 * @see ListenPoint
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ListenPoint(eventType = CanalEntry.EventType.UPDATE)
public @interface UpdateListenPoint {

    /**
     * canal destination default for all
     *
     * @return canal destination
     */
    @AliasFor(annotation = ListenPoint.class)
    String destination() default "";

    /**
     * database schema which you are concentrate on default for all
     *
     * @return canal destination
     */
    @AliasFor(annotation = ListenPoint.class)
    String[] schema() default {};

    /**
     * tables which you are concentrate on default for all
     *
     * @return canal destination
     */
    @AliasFor(annotation = ListenPoint.class)
    String[] table() default {};

}

