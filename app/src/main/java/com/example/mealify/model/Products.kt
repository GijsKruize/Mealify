class ProductModel (private var product_name: String, private var product_date: String, private var product_image: Int) {

    // Getter and Setter
    fun getProduct_name(): String {
        return product_name
    }

    fun setProduct_name(product_name: String) {
        this.product_name = product_name
    }

    fun getProduct_date(): String {
        return product_date
    }

    fun setProduct_date(product_date: String) {
        this.product_date = product_date
    }

    fun getProduct_image(): Int {
        return product_image
    }

    fun setProduct_image(product_image: Int) {
        this.product_image = product_image
    }
}
