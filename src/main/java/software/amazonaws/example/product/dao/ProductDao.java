// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package software.amazonaws.example.product.dao;

import software.amazonaws.example.product.entity.Product;

public interface ProductDao {
  void putProduct(Product product);
}
