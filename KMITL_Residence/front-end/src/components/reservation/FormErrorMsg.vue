<template>
    <div v-if="hasError">
        <div class="ui grid">
            <div class="sixteen wide column">
                <div class="ui error message">
                    <div class="header">Got error!</div>
                    <ul class="list" v-for="error in err">
                        <li>{{ error }}</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="ui hidden divider"></div>
    </div>
</template>

<script>
export default {
    props: ['err'],
    computed:{
        hasError(){
            return !this.err || this.err.length > 0
        }
    }
}
</script>
