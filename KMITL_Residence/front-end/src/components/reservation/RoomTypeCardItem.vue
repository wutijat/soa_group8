<template>
    <div class="column">
        <div class="ui link card">
            <div class="ui fluid card">
                <div class="ui slide masked reveal image">
                    <img src="../../assets/images/1_1.jpg" class="visible content" v-if="id == 1">
                    <img src="../../assets/images/1_2.jpg" class="hidden content" v-if="id == 1">
                    <img src="../../assets/images/2_1.jpg" class="visible content" v-if="id == 2">
                    <img src="../../assets/images/2_2.jpg" class="hidden content" v-if="id == 2">
                    <img src="../../assets/images/3_1.jpg" class="visible content" v-if="id == 3">
                    <img src="../../assets/images/3_2.jpg" class="hidden content" v-if="id == 3">
                </div>
                <div class="content">
                    <div class="header">{{ data.typeNameEn }}</div>
                    <div class="description">
                        {{ data.typeDetailsEn }}
                    </div>
                </div>
                <div class="extra content">
                    <span>Price : {{ +data.typePrice | THBformat }}</span>
                    <span class="right floated">Night : {{ +getTotalNights | atLeastOne }}</span>
                </div>
                <div class="ui bottom attached blue button" @click="setRoomType">
                    <i class="add icon"></i>
                        Book for {{ (+data.typePrice * +getTotalNights) | THBformat }}
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import moment from 'moment'
import numeral from 'numeral'
import { Rooms } from '@/services'

export default {
    props: ['id'],
    data: () => ({
        data: {}
    }),
    mounted () {
        this.getRoomTypeData()
    },
    methods: {
        getRoomTypeData(){
            Rooms.getRoomTypeData(this.id)
                .then((res) => this.getRoomTypeDataCallback(res))
                .catch((err) => {
                    console.log(err)
                })
        },
        getRoomTypeDataCallback(res){
            this.data = res.data
        },

        setRoomType(){
            let stayingInformation = this.$store.getters.getStayingInformation
            stayingInformation.roomType = this.id
            this.$store.dispatch('setStayingInformation', stayingInformation)
            this.$store.dispatch('nextStep')
        }
    },
    computed: {
        getTotalNights(){
            let checkInDate = moment(this.getStayingInformation.checkInDate, "YYYY-M-D")
            let checkOutDate = moment(this.getStayingInformation.checkOutDate, "yyyy-M-D")
            return checkOutDate.diff(checkInDate, 'days') || 1
        },
        getStayingInformation(){
            return this.$store.getters.getStayingInformation
        }
    },
    filters: {
        atLeastOne(val){
            if(val < 1){
                return 1
            }
            return val
        },
        THBformat(val){
            return numeral(+val).format('0,0.00') + ' THB'
        }
    }

}
</script>

<style scoped>
    div.ui.link.card, div.ui.fluid.card {
        height: 100%;
        width: 100%;
        max-width: 450.3px;
        margin: 0 auto;
    }

    div.ui.fluid.card > div.content {
        padding: 1.3em;
    }

    div.ui.fluid.card > div.ui.bottom.attached.blue.button {
        padding: 1.3em;
    }

    div.ui.slide.masked.reveal.image > img.hidden.content {
        height:100%;

    }
</style>
