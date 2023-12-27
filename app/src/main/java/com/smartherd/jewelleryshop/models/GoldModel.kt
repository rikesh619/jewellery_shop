package com.smartherd.jewelleryshop.models

import com.fasterxml.jackson.annotation.JsonProperty

class GoldModel {

    var id : Int? = null

    @JsonProperty("price")
    var price : Double? = null

    @JsonProperty("quality")
    var quality : String? = null

    @JsonProperty("unit")
    var unit : String? = null

}