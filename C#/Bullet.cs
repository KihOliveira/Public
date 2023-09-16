using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bullet : MonoBehaviour
{
    //private GameObject hitEffect;

    private void OnCollisionEnter2D(Collision2D other) {
      //Instantiate(hitEffect, transform.position, Quaternion.identity);
      Destroy(gameObject);
  }
}
