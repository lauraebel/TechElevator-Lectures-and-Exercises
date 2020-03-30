<template>
    <div class="contact">
        <h1>Contact</h1>
        <form>
            <div>
                <label for="name">Name</label>
                <input 
                    type="text"
                    id="name"
                    v-model.trim="contact.name"
                />
            </div>
            <div>
                <label for="email">Email</label>
                <input 
                    type="text"
                    id="email"
                    v-model.trim="contact.email"
                />
            </div>
            <div>
                <label for="emailType">Email Type</label>
                <select id="emailType" v-model="contact.emailType">
                    <option value="" selected>Choose...</option>
                    <option value="WORK">Work</option>
                    <option value="HOME">Home</option>
                    <option value="PERSONAL">Personal</option>
                </select>
            </div>
        </form>

        <div class="result">
            <div class="line-item">
                Name:
                <span class="item-text">{{ contact.name }}</span>
            </div>
            <div class="line-item">
                Email:
                <span class="item-text">{{ contact.email }}</span>
            </div>
            <div class="line-item">
                Email Type:
                <span class="item-text">{{ contact.emailType }}</span>
            </div>
        </div>
    </div>

</template>

<script>
export default {
    name: 'contact-info',
    data() {
        return {
            contact: {
                name: '',
                email: '',
                emailType: ''
            }
        }
    } 
}
</script>

<style scoped>
form div {
    margin-top: 20px;
}
form div label {
    padding-right: 10px;
}
div.result {
    text-align: left;
    margin: auto;
    margin-top: 50px;
    width: 500px;
    background-color: lightgray;
    border-radius: 10px;
    padding: 10px;
}
div.result .line-item {
    font-weight: 800;
    padding-bottom: 10px;
}
.item-text {
    font-weight: 400;
}
</style>
