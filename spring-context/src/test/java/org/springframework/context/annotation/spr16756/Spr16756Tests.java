/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context.annotation.spr16756;

import com.oracle.javafx.jmx.json.JSONFactory;
import jdk.nashorn.internal.objects.NativeJSON;
import jdk.nashorn.internal.parser.JSONParser;
import org.junit.jupiter.api.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Juergen Hoeller
 */
public class Spr16756Tests {

	//todo
	@Test
	public void shouldNotFailOnNestedScopedComponent() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		//最终调用 DefaultListableBeanFactory 中 父类的SimpleAliasRegistry 的registerAlias方法
		context.register(ScanningConfiguration.class);

		//刷新上下文环境
		context.refresh();

		//获取bean
		ScannedComponent bean = context.getBean(ScannedComponent.class);
		ScannedComponent.State bean1 = context.getBean(ScannedComponent.State.class);
		System.out.println("1111111:" + bean.iDoAnything());
		System.out.println("2222222:" + bean1.toString());
	}

}
