// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package software.amazonaws.example.product;

import dagger.Component;
import software.amazonaws.example.product.handler.*;

import javax.inject.Singleton;

@Singleton
@Component(modules = ProductModule.class)
public interface ProductComponent {
  void inject(CreateProductHandler handler);
}
