<template>
  <div class="container">
    <div class="row">
      <div class="col-8">
        <form>
          <div class="form-row">
            <h2>Shipping Address</h2>
          </div>
          <div class="form-group">
            <label for="shippingAddress">Address</label>
            <input
              type="text"
              class="form-control"
              id="shippingAddress"
              placeholder="1234 Main St"
              v-model.trim="shipping.address"
            >
          </div>
          <div class="form-group">
            <label for="shippingAddress2">Address 2</label>
            <input
              type="text"
              class="form-control"
              id="shippingAddress2"
              placeholder="Apartment, studio, or floor"
              v-model.trim="shipping.address2"
            >
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="shippingCity">City</label>
              <input type="text" class="form-control" id="shippingCity" v-model.trim="shipping.city">
            </div>
            <div class="form-group col-md-4">
              <label for="shippingState">State</label>
              <select id="shippingState" class="form-control" v-model.trim="shipping.state">
                <option value="" selected>Choose...</option>
                <option value="MI">MI</option>
                <option value="OH">OH</option>
                <option value="PA">PA</option>
              </select>
            </div>
            <div class="form-group col-md-2">
              <label for="shippingZip">Zip</label>
              <input type="text" class="form-control" id="shippingZip" v-model.trim="shipping.zip">
            </div>
          </div>
          <button type="submit" class="btn btn-primary float-right" disabled>Next Step</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: "address-info",
  data() {
    return {
      billingSameAsShipping: false,
      shipping: {
        address: "",
        address2: "",
        city: "",
        state: "",
        zip: "",
        deliverto: ""
      },
      billing: {
        address: "",
        address2: "",
        city: "",
        state: "",
        zip: ""
      }
    };
  },
  methods: {
    updateBilling() {
      this.billingSameAsShipping = !this.billingSameAsShipping;
      this.billingSameAsShipping ? this.billing = this.shipping : this.clearBillingAddress();
    },
    clearBillingAddress() {
      this.billing = {
        address: "",
        address2: "",
        city: "",
        state: "",
        zip: ""
      }
    }
  }
};
</script>

<style scoped src="bootstrap/dist/css/bootstrap.min.css"/>
