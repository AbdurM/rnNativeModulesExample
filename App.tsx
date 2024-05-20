import { StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import React from 'react'
import { NativeModules } from 'react-native'
const { MyExampleModule } = NativeModules;

const App = () => {
  return (
    <View style={styles.container}>
      <TouchableOpacity onPress={() => MyExampleModule.exampleMethod()} style={styles.button}>
        <Text style={styles.text}>Call the Example native module</Text>
      </TouchableOpacity>
    </View>
  )
}

export default App

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  button: {
    backgroundColor: 'green',
    padding: 10,
  },
  text: {
    color: 'white'
  }
})