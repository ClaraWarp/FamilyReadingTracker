<template>
    <div>
        <p>To create a family fill out the form below. If you a child, wait to be added by your parent.</p>
        <form @submit.prevent>
            <label>
                Enter Family Name:
                <input type="text">
            </label>
            <button>Create</button>
            <button type="button">Back</button>
        </form>
    </div>
</template>

<script>
export default {

}
</script>

<style scoped>

</style>