using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyAI : MonoBehaviour
{
    private Transform player;
    private Rigidbody2D rb;
    private float moveSpeed;
    private Vector2 walkDirection;
    private EnemyAttributes attributes;
    private int damage;

    private void Awake() {
        attributes = this.GetComponent<EnemyAttributes>(); // procura os atributos
        damage = attributes.GetDamage(); //inicializa o dano
        moveSpeed = attributes.GetSpeed(); //inicializa a velocidade
        rb = this.GetComponent<Rigidbody2D>(); //procura o componente (rigidbody) proprio
        player = GameObject.FindGameObjectWithTag("Player").transform;
    }

    void Update() {
        Vector3 direction = (player.position - transform.position).normalized;
        walkDirection = direction; 
    }

    private void FixedUpdate() {
        WalkTo(walkDirection);
    }

    private void WalkTo(Vector2 direction){
        rb.MovePosition((Vector2)transform.position + (direction * moveSpeed * Time.deltaTime));
    }

    private void OnCollisionEnter2D(Collision2D collision) {
        if(collision.gameObject.CompareTag("Player")){
            PlayerAttributes player = collision.gameObject.GetComponent<PlayerAttributes>();
            player.TakeDamage(damage);
            Debug.Log("Vida restante: " + player.GetLife());
        }
    }

}
