<template>
  <div class="park">
      <park-detail />
      <weather />
  </div>
</template>

<script>
import ParkDetail from '@/components/ParkDetail'
import Weather from '@/components/Weather'

export default {
    name: 'Park',
    components: {
        ParkDetail,
        Weather
    }
}
</script>

<style>

</style>