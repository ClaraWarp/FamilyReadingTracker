<template>
    <div class="well">
        <p>To create a family fill out the form below. If you a child, wait to be added by your parent.</p>
        <form @submit.prevent>
            <label>
                Enter Family Name:
                <input type="text">
            </label>
            <button>Create</button>
            <button type="button" @click="toggleCreateFamily">Back</button>
        </form>
    </div>
</template>

<script>
export default {
    methods: {
        toggleCreateFamily() {
            this.$emit('toggleCreateFamily')
        }
    }
}
</script>

<style scoped>

p {
    font-size: 50%;
}

.well {
    border: 3px solid #a9d3ec;
    padding: 10px 10px 10px 20px;
    margin: 10px 10px 5px -3px;
    border-radius: 0px 20px 20px 0px;
    color: white;
}

</style>