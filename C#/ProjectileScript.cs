using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ProjectileScript : MonoBehaviour
{
    private Vector3 mousePos;
    private Camera mainCam;
    private Rigidbody2D rb;
    [SerializeField] private float bulletSpeed = 5f; //Velocidade do projetil
    [SerializeField] private int damage;
    [SerializeField] private PlayerAttributes player;
    //private GameObject hitEffect;

  private void Awake() {
    mainCam = GameObject.FindGameObjectWithTag("MainCamera").GetComponent<Camera>(); //Outra maneira de obter a posiçao do mouse na tela
    mousePos = mainCam.ScreenToWorldPoint(Input.mousePosition);
    rb = GetComponent<Rigidbody2D>();
    Vector3 trajectory = mousePos - transform.position;
    Vector3 rotation = transform.position - mousePos;
    rb.velocity = new Vector2(trajectory.x, trajectory.y).normalized * bulletSpeed; //Faz com que a velocidade do projetil seja a mesma independente da distancia do mouse
    float rot = Mathf.Atan2(rotation.y, rotation.x) *  Mathf.Rad2Deg;
    transform.rotation = Quaternion.Euler(0, 0, rot);

    player = GameObject.FindGameObjectWithTag("Player").GetComponent<PlayerAttributes>(); //Procura os atributos do jogador
  }

  private void Update() {
    damage = player.GetDamage();
  }

  public float GetBulletSpeed(){
    return this.bulletSpeed;
  }

  public void SetBulletSpeed(float bulletSpeed){
    this.bulletSpeed = bulletSpeed;
  }

  private void OnCollisionEnter2D(Collision2D collision) {
    //Instantiate(hitEffect, transform.position, Quaternion.identity);
    
    if(collision.gameObject.CompareTag("Enemy")){
      EnemyAttributes enemy = collision.gameObject.GetComponent<EnemyAttributes>();
      enemy.TakeDamage(damage);
      //Debug.Log("Colidiu com inimigo, vida do inimigo:" + enemy.GetLife());
      Destroy(gameObject);
    }
    else if(collision.gameObject.CompareTag("Wall")){
      //Debug.Log("Colidiu com uma parede");
      Destroy(gameObject);
    }

    
  }

}
