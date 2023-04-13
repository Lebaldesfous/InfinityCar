<template>
    <div class="modal" @click="$emit('close')">
      <div class="modal-content" @click.stop>
        <slot></slot>
      </div>
    </div>
  </template>
  
  <style scoped>
  .modal {
    display: flex;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    justify-content: center;
    align-items: center;
  }
  
  .modal-content {
    background-color: #fff;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
  }
  </style>