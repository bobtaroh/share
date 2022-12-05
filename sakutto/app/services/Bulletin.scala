package services

import javax.inject.Inject

import anorm.SqlParser._
import anorm._
import play.api.db.DBApi

import scala.language.postfixOps

case class Bulletin(id:Option[Long], title: String, name: String, content: String)

@javax.inject.Singleton
class BulletinService @Inject() (dbapi: DBApi) {

  private val db = dbapi.database("default")

  val simple = {
    get[Option[Long]]("bulletin.id") ~
    get[String]("bulletin.title") ~
    get[String]("bulletin.name") ~
    get[String]("bulletin.content") map {
      case id ~ title ~ name ~ content => Bulletin(id, title, name, content)
    }
  }

  def list(): Seq[Bulletin] = {

    db.withConnection { implicit connection =>

      SQL(
        """
          select * from bulletin
        """
      ).as(simple *)
    }
  }

  def insert(bulletin: Bulletin) = {
    db.withConnection { implicit connection =>
      SQL(
        """
        insert into bulletin values ((select next value for bulletin_seq), {title}, {name}, {content})
        """
      ).on(
        "title" -> bulletin.title,
        "name" -> bulletin.name,
        "content" -> bulletin.content
      ).executeUpdate()
    }
  }

  def findById(id: Long): Option[Bulletin] = {
    db.withConnection { implicit connection =>
      SQL("select * from bulletin where id = {id}").on("id" -> id).as(simple.singleOpt)
    }
  }

  def update(id: Long, bulletin: Bulletin) = {
    db.withConnection { implicit connection =>
      SQL(
        """
            update bulletin
            set
            title = {title},
            name = {name},
            content = {content}
            where id = {id}
          """
      ).on(
        "id" -> id,
        "title" -> bulletin.title,
        "name" -> bulletin.name,
        "content" -> bulletin.content
      ).executeUpdate()
    }
  }

  def delete(id: Long) = {
    db.withConnection { implicit connection =>
      SQL("delete from bulletin where id = {id}").on("id" -> id).executeUpdate()
    }
  }

}