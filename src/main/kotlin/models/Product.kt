package models

data class Product(
    val country_code: String,
    val country_id: String,
    val country_name: String,
    val manufacturer_id: String,
    val manufacturer_name: String,
    val product_barcode: String,
    val product_description: String,
    val product_id: String,
    val product_image: String,
    val product_is_real_barcode: String,
    val product_name: String,
    val product_quantity: String,
    val product_quantity_item: String,
    val product_unit_id: String,
    val product_unit_name: String,
    val product_unit_type: String,
    val product_update_time: String
)