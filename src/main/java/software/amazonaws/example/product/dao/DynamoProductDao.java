// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package software.amazonaws.example.product.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazonaws.example.product.entity.Product;

public class DynamoProductDao implements ProductDao {
  private static final Logger logger = LoggerFactory.getLogger(DynamoProductDao.class);
  private static final String PRODUCT_TABLE_NAME = System.getenv("PRODUCT_TABLE_NAME");
  private final DynamoDbClient dynamoDbClient;

  public DynamoProductDao(DynamoDbClient client) {
    this.dynamoDbClient = client;
  }

  @Override
  public void putProduct(Product product) {
    dynamoDbClient.putItem(PutItemRequest.builder()
      .tableName(PRODUCT_TABLE_NAME)
      .item(ProductMapper.productToDynamoDb(product))
      .build());
  }
}
