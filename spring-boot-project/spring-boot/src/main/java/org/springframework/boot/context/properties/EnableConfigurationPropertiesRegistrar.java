/*
 * Copyright 2012-2019 the original author or authors.
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

package org.springframework.boot.context.properties;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.type.AnnotationMetadata;

/**
 * {@link ImportBeanDefinitionRegistrar} for
 * {@link EnableConfigurationProperties @EnableConfigurationProperties}.
 *
 * @author Phillip Webb
 */
class EnableConfigurationPropertiesRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
		//注册几个基础的bean,重点是ConfigurationPropertiesBindingPostProcessor，它是处理属性值映射的核心类
		registerInfrastructureBeans(registry);

		/**
		 * @EnableConfigurationProperties(Person.class)
		 * 这里是将@EnableConfigurationProperties注解里的value值对应的类(如:Person)注册为spring的一个bean;最终让
		 * ConfigurationPropertiesBindingPostProcessor这个后处理器在bean初始化之前拦截处理
		 */
		ConfigurationPropertiesBeanRegistrar beanRegistrar = new ConfigurationPropertiesBeanRegistrar(registry);
		getTypes(metadata).forEach(beanRegistrar::register);
	}

	private Set<Class<?>> getTypes(AnnotationMetadata metadata) {
		return metadata.getAnnotations().stream(EnableConfigurationProperties.class)
				.flatMap((annotation) -> Arrays.stream(annotation.getClassArray(MergedAnnotation.VALUE)))
				.filter((type) -> void.class != type).collect(Collectors.toSet());
	}

	@SuppressWarnings("deprecation")
	static void registerInfrastructureBeans(BeanDefinitionRegistry registry) {
		ConfigurationPropertiesBindingPostProcessor.register(registry);
		ConfigurationPropertiesBeanDefinitionValidator.register(registry);
		ConfigurationBeanFactoryMetadata.register(registry);
	}

}
